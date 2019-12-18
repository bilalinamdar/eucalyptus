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
package com.eucalyptus.auth.euare.common.msgs;

import java.util.ArrayList;
import com.eucalyptus.auth.euare.common.policy.IamPolicySpec;
import com.eucalyptus.auth.policy.PolicySpec;
import com.eucalyptus.auth.policy.annotation.PolicyAction;
import com.eucalyptus.binding.HttpParameterMapping;
import com.google.common.collect.Lists;

@PolicyAction( vendor = PolicySpec.VENDOR_IAM, action = IamPolicySpec.IAM_CREATEOPENIDCONNECTPROVIDER )
public class CreateOpenIdConnectProviderType extends EuareMessage implements EuareMessageWithDelegate {

  private String delegateAccount;
  @HttpParameterMapping( parameter = "ClientIDList.member" )
  private ArrayList<String> clientIDList = Lists.newArrayList( );
  @HttpParameterMapping( parameter = "ThumbprintList.member" )
  private ArrayList<String> thumbprintList = Lists.newArrayList( );
  private String url;

  public String getDelegateAccount( ) {
    return delegateAccount;
  }

  public void setDelegateAccount( String delegateAccount ) {
    this.delegateAccount = delegateAccount;
  }

  public ArrayList<String> getClientIDList( ) {
    return clientIDList;
  }

  public void setClientIDList( ArrayList<String> clientIDList ) {
    this.clientIDList = clientIDList;
  }

  public ArrayList<String> getThumbprintList( ) {
    return thumbprintList;
  }

  public void setThumbprintList( ArrayList<String> thumbprintList ) {
    this.thumbprintList = thumbprintList;
  }

  public String getUrl( ) {
    return url;
  }

  public void setUrl( String url ) {
    this.url = url;
  }
}