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
    (let [next-queue (queue :next)
          updated-queue (push next-queue element)]
      (assoc queue :next updated-queue))
    ))

(defn fifo-pop [queue]
  (if (= (size queue) 0)
    (vector (new-queue) nil)
    (let [content-value (queue :content)
          popped-queue (queue :next)]
      (vector popped-queue content-value))))

(defn lifo-pop [queue]
  (if (= (size queue) 0)
    (vector (new-queue) nil))
  (let [next (get queue :next)]
    (if (= (size next) 0)
      (queue :content)
      (lifo-pop (queue :next)))))

