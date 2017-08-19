package com.github.evis.highloadcup2017.model

import java.time.Instant

case class UserVisits(visits: Iterable[UserVisit])

case class UserVisit(visitId: Int,
                     mark: Int,
                     visitedAt: Instant,
                     place: String,
                     country: String,
                     distance: Int) {

  def `with`(update: VisitUpdate): UserVisit = copy(
    mark = update.mark.getOrElse(mark),
    visitedAt = update.visitedAt.getOrElse(visitedAt),
  )
}

case class UserVisitsRequest(user: Int,
                             fromDate: Option[Instant],
                             toDate: Option[Instant],
                             country: Option[String],
                             toDistance: Option[Int])