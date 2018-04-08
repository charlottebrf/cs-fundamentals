(ns alphabet.alphabet_test
  (:require [clojure.test :refer :all]
            [alphabet.alphabet_sort :refer :all]))

(deftest check-alphabet
  (testing "an alphabet contains 10 unique letters"
    (is (= (count alphabet) 10))
    (is (= (type alphabet) clojure.lang.PersistentHashSet))))

(deftest translate-word
  (testing "if a word is nil it will be translated as an empty set"
    (is (= (translate nil) #{}))
    (is (= (translate [nil]) #{nil})))
;:TODO how would I turn a string into a vector and then into a map of keywords?
  (testing "a single word is translated as a keyword in a set"
    (is (= (translate ["w"]) #{:w})))
  (testing "words coming into the program as a vector of strings are translated to a set of keywords"
    (is (= (translate ["w" "o" "r" "d"]) #{:w :o :r :d})))
  (testing "duplicate letters in translated sets will be removed"
    (is (= (translate ["w" "o" "r" "d" "w" "o"]) #{:w :o :r :d}))))

(deftest check-word
  (testing "an empty word is not found in the alphabet"
    (is (= (in-alphabet? nil) false)))
  (testing "a letter outside the alphabet are not found"
    (is (= (in-alphabet? "y") false)))
  (testing "multiple letters outside the alphabet are not found"
    (is (= (in-alphabet? ["x" "y" "z"]))))
  (testing "a letter in the alphabet is found"
    (is (= (in-alphabet? "d") true)))
  (testing "multiple letters from the alphabet are found"
    (is (= (in-alphabet? ["a" "d"]) true))))
