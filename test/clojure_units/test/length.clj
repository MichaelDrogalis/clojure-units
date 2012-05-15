(ns clojure_units.test.length
  (:use [clojure.test])
  (:require [clojure_units.length])
  (:import [clojure_units.length Miles])
  (:import [clojure_units.length Kilometers])
  (:import [clojure_units.length Meters])
  (:use [clojure_units.length]))

(deftest miles-to-miles
  (is
   (= (to-miles (Miles. 5)) (Miles. 5))
   "Converting miles to miles returned a different length."))

(deftest miles-to-km
  (is
   (= (to-km (Miles. 1)) (Kilometers. 1.609))
   "Converting miles to kilometers failed."))

(deftest miles-to-meters
  (is
   (= (to-meters (Miles. 1)) (Meters. 1609))
   "Converting miles to meters failed."))

(deftest km-to-km
  (is
   (= (to-km (Kilometers. 5)) (Kilometers. 5))
   "Converting kilometers to kilometers returned a different length."))

(deftest km-to-miles
  (is
   (= (to-miles (Kilometers. 1.609)) (Miles. 1))
   "Converting kilometers to miles failed."))

(deftest km-to-meters
  (is
   (= (to-meters (Kilometers. 1)) (Meters. 1000))
   "Converting kilometers to meters failed."))

(deftest meters-to-meters
  (is
   (= (to-meters (Meters. 500)) (Meters. 500))
   "Converting meters to meters failed."))

(deftest meters-to-kilometers
  (is
   (= (to-km (Meters. 1000)) (Kilometers. 1))
   "Converting meters to kilometers failed."))

(deftest meters-to-miles
  (is
   (= (to-miles (Meters. 1609)) (Miles. 1))
   "Converting meters to miles failed."))