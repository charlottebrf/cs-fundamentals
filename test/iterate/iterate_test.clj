(ns iterate.iterate-test
  (:require [clojure.test :refer :all]
            [iterate.iterate :refer :all]))


;In a reduce function have an accumulator and a value
;Reduce will produce a data structure that can be a different size to its original


  (deftest iterating-elements-in-collection
    (testing "Adds up numbers in a collection"
      (is (= (sum-numbers [2 2 2]) 6)))
    (testing "Converts a vector to a set"
      (is (= (convert-to-set [:a :b :c]) #{:a :b :c})))
    (comment
    (testing "if a number is below 10 then store it in the new set"
      (is (= (numbers-under-ten [1 2 3 4 5]) #{1 2 3 4 5})))))

