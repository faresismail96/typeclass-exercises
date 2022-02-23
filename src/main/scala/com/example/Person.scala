package com.example

case class Person(name: String, id: Int)

object Person {
  object Instances {

    implicit val eqByName: Eq[Person] = (a: Person, b: Person) =>
      a.name.eq(b.name)

    implicit val eqById: Eq[Person] = (a: Person, b: Person) =>
      Eq[Int].eq(a.id, b.id)

  }
}
