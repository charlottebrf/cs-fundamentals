(ns alphabet.alphabet_test
  (:require [clojure.test :refer :all]
            [alphabet.alphabet_sort :refer :all]))

(deftest check-alphabet
  (testing "an alphabet contains 10 unique letters"
    (is (= (count alphabet) 10))
    (is (= (type alphabet) clojure.lang.PersistentHashSet))))

(deftest check-word
  (testing "an empty word does not appear in the alphabet"
    (is (= (in-alphabet? nil) false)))
  (testing "letters outside the alphabet are not found in the alphabet"
    (is (= (in-alphabet? :y) false)))
  (testing "multiple letters outside the alphabet are not found in the alphabet"
    (is (= (in-alphabet? [:x :y :z])))))
