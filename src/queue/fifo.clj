(ns queue.fifo)

(defn nested-queue [element]
  {:content element :next nil})

(defn new-queue []
  (nested-queue nil))

(defn size [queue]
  (if (some? (get queue :content))
    (do (+ 1 (size (queue :next))))
    0))


(defn push [queue element]
  (if (nil? (get queue :content))
    (assoc queue :content element)
    (let [next-queue (get queue :next)
          updated-queue (push next-queue element)]
      (assoc queue :next updated-queue))
    ))

(defn special-pop [queue]
  (let [content-element (get queue :content)
        updated-queue (dissoc queue :content)]
    (if (some? content-element)
      (do (vector updated-queue content-element))
      (do (special-pop (get updated-queue :next)))
      )))

