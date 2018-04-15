(ns alphabet.alphabet_test
  (:require [clojure.test :refer :all]
            [alphabet.alphabet_sort :refer :all]))

(deftest check-alphabet
  (testing "an alphabet contains 10 unique letters"
    (is (= (count alphabet) 10))
    (is (= (type alphabet) clojure.lang.PersistentHashSet))))

(deftest turns-word-into-list
  (testing "given a string of words will return a list of each letter"
    (is (= (word-to-list "hey") '("y" "e" "h")))))

(deftest check-word
  (testing "an empty word is not found in the alphabet"
    (is (= (in-alphabet? '()) false)))
  (testing "a letter outside the alphabet is not found"
    (is (= (in-alphabet? '("y")) false)))
  (testing "multiple letters outside the alphabet are not found"
    (is (= (in-alphabet? '("x" "y" "z")))))
  (testing "a letter in the alphabet is found"
    (is (= (in-alphabet? '("d")) true)))
  (testing "multiple letters from the alphabet are found"
    (is (= (in-alphabet? '("a" "d")) true)))
  (testing "a letter from and one not from alphabet are not found"
    (is (= (in-alphabet? '("a" "x")) false)))
  (testing "multiple letters not and from alphabet are not found"
    (is (= (in-alphabet? '("x" "b" "y" "a" )) false)))
  (testing "multiple letters from and not in alphabet are not found"
    (is (= (in-alphabet? '("b" "!" "a" "?" )) false))))


(deftest check-word-version-two
  (testing "an empty word is not found in the alphabet"
    (is (= (in-alphabet-version-two? '()) false)))
  (testing "a letter outside the alphabet is not found"
    (is (= (in-alphabet-version-two? '("y")) false)))
  (testing "multiple letters outside the alphabet are not found"
    (is (= (in-alphabet-version-two? '("x" "y" "z")) false)))
  (testing "a letter in the alphabet is found"
    (is (= (in-alphabet-version-two? '("a")) true)))
  (testing "multi[le letters from the alphabet are found"
    (is (= (in-alphabet-version-two?  '("a" "d") true))))
  (testing "a letter from and one not from alphabet are not found"
    (is (= (in-alphabet-version-two? '("a" "x")) false)))
  (testing "multiple letters not and from alphabet are not found"
    (is (= (in-alphabet-version-two? '("x" "b" "y" "a")) false)))
  (testing "multiple letters from and not in alphabet are not found"
    (is (= (in-alphabet-version-two? '("b" "!" "a" "?"))))))

(deftest check-word-version-three
  (testing "an empty word is not found in the alphabet"
    (is (= (in-alphabet-version-three? "") false)))
  (testing "a letter outside the alphabet is not found"
    (is (= (in-alphabet-version-three? "y") false)))
  (testing "multiple letters outside the alphabet are not found"
    (is (= (in-alphabet-version-three? "xyz") false)))
  (testing "a letter in the alphabet is found"
    (is (= (in-alphabet-version-three? "a") true)))
  (testing "multi[le letters from the alphabet are found"
    (is (= (in-alphabet-version-three? "ad") true)))
  (testing "a letter from and one not from alphabet are not found"
    (is (= (in-alphabet-version-three? "ax") false)))
  (testing "multiple letters not and from alphabet are not found"
    (is (= (in-alphabet-version-three? "xbya") false)))
  (testing "multiple letters from and not in alphabet are not found"
    (is (= (in-alphabet-version-three? "b!a?")))))




