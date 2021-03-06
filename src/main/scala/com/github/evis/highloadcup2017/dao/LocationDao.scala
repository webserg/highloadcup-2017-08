package com.github.evis.highloadcup2017.dao

import com.github.evis.highloadcup2017.api.JsonFormats
import com.github.evis.highloadcup2017.model.{Location, LocationUpdate}

class LocationDao extends JsonFormats with Dao[Location] {
  private val locations = Array.fill[Location](800000)(null)

  private var visitDao: VisitDao = _

  def create(location: Location): Unit =
    locations.update(location.id, location)

  def read(id: Int): Location = locations(id)

  //noinspection UnitInMap
  def update(id: Int, update: LocationUpdate): Unit = {
    val location = locations(id)
    val updated = location `with` update
    locations.update(id, updated)
  }

  def setVisitDao(visitDao: VisitDao): Unit =
    if (this.visitDao == null) this.visitDao = visitDao
    else throw new RuntimeException("setVisitDao() should be invoked once")
}
