/*************************************************************************
 * Copyright 2009-2014 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.storage.msgs.s3;

import java.util.Objects;
import edu.ucsb.eucalyptus.msgs.EucalyptusData;

public class AccessControlPolicy extends EucalyptusData {

  private CanonicalUser owner;
  private AccessControlList accessControlList;

  public AccessControlPolicy( ) {
  }

  public AccessControlPolicy( CanonicalUser owner, AccessControlList acl ) {
    this.owner = owner;
    this.accessControlList = acl;
  }

  @Override
  public boolean equals( final Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass( ) != o.getClass( ) ) return false;
    final AccessControlPolicy that = (AccessControlPolicy) o;
    return Objects.equals( getOwner( ), that.getOwner( ) ) &&
        Objects.equals( getAccessControlList( ), that.getAccessControlList( ) );
  }

  @Override
  public int hashCode( ) {
    return Objects.hash( getOwner( ), getAccessControlList( ) );
  }

  public CanonicalUser getOwner( ) {
    return owner;
  }

  public void setOwner( CanonicalUser owner ) {
    this.owner = owner;
  }

  public AccessControlList getAccessControlList( ) {
    return accessControlList;
  }

  public void setAccessControlList( AccessControlList accessControlList ) {
    this.accessControlList = accessControlList;
  }
}
