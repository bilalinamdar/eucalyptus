/*************************************************************************
 * Copyright 2016 Ent. Services Development Corporation LP
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
package com.eucalyptus.tokens.oidc;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import com.eucalyptus.util.Json;
import com.eucalyptus.util.Parameters;
import com.fasterxml.jackson.databind.JsonNode;
import io.vavr.control.Option;

/**
 *
 */
public class EcJsonWebKey extends JsonWebKey {

  public static final String TYPE = "EC";

  private final String crv;
  private final String x;
  private final String y;

  static EcJsonWebKey fromJson( final JsonNode keyObject ) throws IOException {
    assertKty( keyObject, TYPE );
    return new EcJsonWebKey(
        alg( keyObject ),
        kid( keyObject ),
        use( keyObject ),
        keyOps( keyObject ),
        x5c( keyObject ),
        Json.text( keyObject, "crv" ),
        Json.text( keyObject, "x" ),
        Json.text( keyObject, "y" )
    );
  }

  EcJsonWebKey( final String alg,
                final Option<String> kid,
                final Option<String> use,
                final Option<List<String>> keyOps,
                final Option<List<String>> x5c,
                final String crv,
                final String x,
                final String y ) {
    super( alg, kid, use, keyOps, x5c );
    this.crv = Parameters.checkParamNotNull( "crv", crv );
    this.x = Parameters.checkParamNotNull( "x", x );
    this.y = Parameters.checkParamNotNull( "y", y );
  }

  @Nonnull
  @Override
  public String getKty() {
    return TYPE;
  }

  @Nonnull
  public String getCrv( ) {
    return crv;
  }

  @Nonnull
  public String getX( ) {
    return x;
  }

  @Nonnull
  public String getY( ) {
    return y;
  }
}
