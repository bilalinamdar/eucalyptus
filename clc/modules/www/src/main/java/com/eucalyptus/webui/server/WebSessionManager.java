package com.eucalyptus.webui.server;

import java.util.Map;
import com.google.common.collect.Maps;
import edu.ucsb.eucalyptus.admin.server.ServletUtils;

/**
 * Web session manager, maintaining a web session registrar.
 * 
 * @author Ye Wen (wenye@eucalyptus.com)
 *
 */
public class WebSessionManager {

  public static final long SESSION_LIFE_IN_MILLIS = 2 * 7 * 24 * 60 * 60 * 1000;// 2 weeks in millis
  
  private static WebSessionManager instance = null;
  
  private Map<String, WebSession> sessions = Maps.newHashMap( );
  
  private WebSessionManager( ) {
    
  }
  
  public static synchronized WebSessionManager getInstance( ) {
    if ( instance == null ) {
      instance = new WebSessionManager( );
    }
    return instance;
  }
  
  /**
   * Create new web session record.
   * 
   * @param userName
   * @param accountName
   * @return the new session ID.
   */
  public synchronized String newSession( String userName, String accountName ) {
    String id = ServletUtils.genGUID( );
    long time = System.currentTimeMillis( );
    WebSession session = new WebSession( id, userName, accountName, time/*creationTime*/, time/*lastAccessTime*/ );
    sessions.put( id, session );
    return id;
  }
  
  /**
   * Get a session by ID. Remove this session if expired.
   * 
   * @param id
   * @return the session, null if not exists or expired.
   */
  public synchronized WebSession getSession( String id ) {
    WebSession session = sessions.get( id );
    if ( session != null ) {
      if ( System.currentTimeMillis( ) - session.getCreationTime( ) > SESSION_LIFE_IN_MILLIS ) {
        sessions.remove( id );
        session = null;
      }
    }
    return session;
  }
  
  /**
   * Remove a session.
   * 
   * @param id
   */
  public synchronized void removeSession( String id ) {
    if ( id != null ) {
      sessions.remove( id );
    }
  }
  
}
