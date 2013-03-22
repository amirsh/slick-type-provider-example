import scala.slick.typeproviders.TypeProvider

object Test extends App {
    object Db1 extends TypeProvider.Db("type-providers-h2mem")
    import Db1.driver.simple._
    import Database.threadLocalSession
    import Db1._
    database.withSession {
      val q1 = Query(Supps.length)
      println("Size of Suppliers before change " +
        q1.first)
      Supps.insert(Supplier(1, "1", "2", "3", "4", "5"))
      val q2 = Query(Supps.length)
      println("Size of Suppliers after change " +
        q2.first)
      val q3 = Query(Coffs.length)
      println("Size of Coffees " + 
        q3.first)
      val r = Query(Coffs).list.head
      val c: Coffee = r
      println("First element of Coffees " + c)
      println("should be " + Coffee("coffee", 1, 2.3, 4, 5))
    }
}
