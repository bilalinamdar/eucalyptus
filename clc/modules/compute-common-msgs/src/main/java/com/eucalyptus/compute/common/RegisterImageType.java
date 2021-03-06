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
package com.eucalyptus.compute.common;

import java.util.ArrayList;
import com.eucalyptus.binding.HttpEmbedded;
import com.eucalyptus.binding.HttpParameterMapping;

public class RegisterImageType extends VmImageMessage {

  private String imageLocation;
  private String amiId;
  private String name;
  private String description;
  private String architecture;
  private String kernelId;
  private String ramdiskId;
  private String rootDeviceName;
  private String virtualizationType;
  private String platform;
  private String sriovNetSupport;
  @HttpParameterMapping( parameter = "BlockDeviceMapping" )
  @HttpEmbedded( multiple = true )
  private ArrayList<BlockDeviceMappingItemType> blockDeviceMappings = new ArrayList<BlockDeviceMappingItemType>( );

  public String getImageLocation( ) {
    return imageLocation;
  }

  public void setImageLocation( String imageLocation ) {
    this.imageLocation = imageLocation;
  }

  public String getAmiId( ) {
    return amiId;
  }

  public void setAmiId( String amiId ) {
    this.amiId = amiId;
  }

  public String getName( ) {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  public String getArchitecture( ) {
    return architecture;
  }

  public void setArchitecture( String architecture ) {
    this.architecture = architecture;
  }

  public String getKernelId( ) {
    return kernelId;
  }

  public void setKernelId( String kernelId ) {
    this.kernelId = kernelId;
  }

  public String getRamdiskId( ) {
    return ramdiskId;
  }

  public void setRamdiskId( String ramdiskId ) {
    this.ramdiskId = ramdiskId;
  }

  public String getRootDeviceName( ) {
    return rootDeviceName;
  }

  public void setRootDeviceName( String rootDeviceName ) {
    this.rootDeviceName = rootDeviceName;
  }

  public String getVirtualizationType( ) {
    return virtualizationType;
  }

  public void setVirtualizationType( String virtualizationType ) {
    this.virtualizationType = virtualizationType;
  }

  public String getPlatform( ) {
    return platform;
  }

  public void setPlatform( String platform ) {
    this.platform = platform;
  }

  public String getSriovNetSupport( ) {
    return sriovNetSupport;
  }

  public void setSriovNetSupport( String sriovNetSupport ) {
    this.sriovNetSupport = sriovNetSupport;
  }

  public ArrayList<BlockDeviceMappingItemType> getBlockDeviceMappings( ) {
    return blockDeviceMappings;
  }

  public void setBlockDeviceMappings( ArrayList<BlockDeviceMappingItemType> blockDeviceMappings ) {
    this.blockDeviceMappings = blockDeviceMappings;
  }
}
