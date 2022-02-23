package com.example

trait Eq[A] {
  def eq(a: A, b: A): Boolean
}

object Eq {
  def apply[A](implicit ev: Eq[A]): Eq[A] = ev

  def instance[A](f: (A, A) => Boolean): Eq[A] = (a: A, b: A) => f(a, b)

  implicit val stringEq: Eq[String] = instance[String]((a, b) => a.equals(b))

  implicit val intEq: Eq[Int] = instance[Int]((a, b) => a == b)

  implicit val personEq: Eq[Person] =
    instance[Person]((p1, p2) =>
      Eq[Int].eq(p1.id, p2.id) && Eq[String].eq(p1.name, p2.name)
    )

  implicit def optionEq[A](implicit eqA: Eq[A]): Eq[Option[A]] =
    (a: Option[A], b: Option[A]) =>
      (a, b) match {
        case (Some(a), Some(b)) => eqA.eq(a, b)
        case (None, None)       => true
        case _                  => false
      }

  object Syntax {
    implicit class EqOps[A](a: A) {
      def eqTo(b: A)(implicit ev: Eq[A]): Boolean = ev.eq(a, b)
    }
  }
}
