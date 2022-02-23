package com.example.laws

import com.example.Eq

trait EqLaws[A] {
  def eq: Eq[A]

  def reflexivity(a: A): Boolean = eq.eq(a, a)

  def symmetry(a: A, b: A): Boolean = !eq.eq(a, b) || eq.eq(b, a)

  def transitivity(a: A, b: A, c: A): Boolean =
    !(eq.eq(a, b) && eq.eq(b, c)) || eq.eq(a, c)

}
