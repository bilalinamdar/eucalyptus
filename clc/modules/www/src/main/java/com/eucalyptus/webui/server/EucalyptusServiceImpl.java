package com.eucalyptus.webui.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import com.eucalyptus.webui.client.service.CategoryItem;
import com.eucalyptus.webui.client.service.CategoryTag;
import com.eucalyptus.webui.client.service.EucalyptusService;
import com.eucalyptus.webui.client.service.EucalyptusServiceException;
import com.eucalyptus.webui.client.service.LoginUserProfile;
import com.eucalyptus.webui.client.service.SearchRange;
import com.eucalyptus.webui.client.service.SearchResult;
import com.eucalyptus.webui.client.service.SearchResultFieldDesc;
import com.eucalyptus.webui.client.service.SearchResultRow;
import com.eucalyptus.webui.client.service.Session;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EucalyptusServiceImpl extends RemoteServiceServlet implements EucalyptusService {

  private static final long serialVersionUID = 1L;

  @Override
  public Session login( String fullname, String password ) throws EucalyptusServiceException {
    return new Session( "FAKESESSIONID" );
  }

  @Override
  public LoginUserProfile getLoginUserProfile( Session session ) throws EucalyptusServiceException {
    return new LoginUserProfile( "admin", "eucalyptus" );
  }

  @Override
  public HashMap<String, String> getSystemProperties( Session session ) throws EucalyptusServiceException {
    HashMap<String, String> props = Maps.newHashMap( );
    props.put( "version", "Eucalyptus EEE 3.0" );
    props.put( "search-result-page-size", "5" );
    return props;
  }

  @Override
  public ArrayList<CategoryTag> getCategory( Session session ) throws EucalyptusServiceException {
    ArrayList<CategoryTag> tags = Lists.newArrayList( );
    ArrayList<CategoryItem> list = Lists.newArrayList( );
    list.add( new CategoryItem( "Start", "Start guide", "home", "start:" ) );
    list.add( new CategoryItem( "Configuration", "System configurations", "config", "config:" ) );
    tags.add( new CategoryTag( "System", list ) );
    list = Lists.newArrayList( );
    list.add( new CategoryItem( "Account", "Accounts", "dollar", "account:" ) );
    list.add( new CategoryItem( "Group", "User groups", "group", "group:" ) );
    list.add( new CategoryItem( "User", "Users", "user", "user:" ) );
    tags.add( new CategoryTag( "Identity", list ) );
    list = Lists.newArrayList( );
    list.add( new CategoryItem( "Image", "Virtual machine images (EMIs)", "image", "image:" ) );
    list.add( new CategoryItem( "VmType", "Virtual machine types", "type", "vmtype:" ) );
    list.add( new CategoryItem( "Report", "Resource usage report", "report", "report:" ) );
    tags.add( new CategoryTag( "Resource", list ) );
    list = Lists.newArrayList( );
    list.add( new CategoryItem( "Extra", "Extra downloads", "down", "extra:" ) );
    tags.add( new CategoryTag( "Miscs", list ) );    
    return tags;
  }

  private static final List<SearchResultRow> DATA = Arrays.asList( new SearchResultRow( Arrays.asList( "test0", "0" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test1", "1" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test2", "2" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test3", "3" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test4", "4" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test5", "5" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test6", "6" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test7", "7" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test8", "8" ) ),
                                                                   new SearchResultRow( Arrays.asList( "test9", "9" ) ),
                                                                   new SearchResultRow( Arrays.asList( "testA", "A" ) )
                                                                 );
  private static final List<SearchResultFieldDesc> FIELDS = Arrays.asList( new SearchResultFieldDesc( "Name", true, "40%" ),
                                                                           new SearchResultFieldDesc( "Id", true, "60%" )
                                                                         );
  @Override
  public SearchResult lookupAccount( Session session, String search, SearchRange range ) throws EucalyptusServiceException {
    System.out.println( "New search: " + range );
    
    final int sortField = range.getSortField( );
    final boolean ascending = range.isAscending( );
    Collections.sort( DATA, new Comparator<SearchResultRow>( ) {
      @Override
      public int compare( SearchResultRow r1, SearchResultRow r2 ) {
        if ( r1 == r2 ) {
          return 0;
        }
        // Compare the name columns.
        int diff = -1;
        if ( r1 != null ) {
          diff = ( r2 != null ) ? r1.getField( sortField ).compareTo( r2.getField( sortField ) ) : 1;
        }
        return ascending ? diff : -diff;
      }
    } );
    int resultLength = Math.min( range.getLength( ), DATA.size( ) - range.getStart( ) );
    SearchResult result = new SearchResult( DATA.size( ), range.getStart( ), resultLength );
    result.setDescs( FIELDS );
    result.setRows( DATA.subList( range.getStart( ), range.getStart( ) + resultLength ) );
    
    for ( SearchResultRow row : result.getRows( ) ) {
      System.out.println( "Row: " + row );
    }
    
    return result;
  }

}
