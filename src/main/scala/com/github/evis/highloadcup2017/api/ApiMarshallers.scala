package com.github.evis.highloadcup2017.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshalling.GenericMarshallers

trait ApiMarshallers extends GenericMarshallers with SprayJsonSupport
