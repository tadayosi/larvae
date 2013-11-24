package larvae.gatling
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.core.Predef.assertions._
import io.gatling.core.Predef.bootstrap._
import io.gatling.http.Headers._
import io.gatling.http.Predef._

class SampleScenario extends Simulation {

    val scn = scenario("Sample Scenario")
        .exec(http("localhost").get("http://localhost:8080/larva-gatling"))

    setUp(scn.inject(
        atOnce(3 user),
        ramp(3 users) over (3 seconds),
        constantRate(1 usersPerSec) during (3 seconds)))
        .protocols(http.shareConnections);

}
