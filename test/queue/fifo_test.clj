(ns queue.fifo_test
  (:require [clojure.test :refer :all]
            [queue.fifo :refer :all]))

(deftest queues
  (testing "a new queue has size zero"
    (let [queue (new-queue)]
      (is (= (size queue) 0))))

  (testing "pushing into an existing queue increases its size by one"
    (let [queue (new-queue)
          added-queue (push queue "Apple")]
      (is (= (size added-queue) 1))))

  (testing "pushing a second elements into an existing queue of one element increases its size by one"
    (let [queue (new-queue)
          queue1 (push queue "Apple")
          queue2 (push queue1 "Bannana")]
      (is (= (size queue2) 2))))

  (testing "pushing a third elements into an existing queue with two elements increases size by one"
    (let [queue (new-queue)
          queue1 (push queue "Apple")
          queue2 (push queue1 "Bannana")
          queue3 (push queue2 "Cherry")]
      (is (= (size queue3) 3))))

  (testing "popping out an existing queue returns a tuple of the new queue containing the popped element"
    (let [queue (new-queue)
          added-queue (push queue "Apple")
          [_ elem] (special-pop added-queue)]
      (is (= elem "Apple"))))

  (testing "popping out of an existing queue decreases its size to zero"
    (let [queue (new-queue)
          added-queue (push queue "Apple")
          removed-queue (special-pop added-queue)]
      (is (= (size removed-queue) 0))))

  (testing "popping out of an existing queue of two decreases its size to one"
    (let [queue (new-queue)
          first-queue (push queue "Apple")
          second-queue (push first-queue "Bannana")
          [q _] (special-pop second-queue)]
      (is (= (size q) 1))))

  (testing "popping out of an existing queue of three decreases its size to two"
    (let [queue (new-queue)
          first-queue (push queue "Apple")
          second-queue (push first-queue "Bannana")
          third-queue (push second-queue "Cherry")
          [q _] (special-pop third-queue)]
      (is (= (size q) 2))))

  (testing "popping out of an empty queue will have the same size of zero"
    (let [queue (new-queue)
          [removed-queue _] (special-pop queue)]
      (is (= (size removed-queue) 0)))))


