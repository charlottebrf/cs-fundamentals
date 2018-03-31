(ns queue.fifo)

(defn nested-queue [element]
  {:content element :next nil})

(defn new-queue []
  (nested-queue nil))

(defn size [queue]
  (if (some? (get queue :content))
    (+ 1 (size (queue :next)))
    0))


(defn push [queue element]
  (if (nil? (get queue :content))
    (assoc queue :content element)
    (let [next-queue (get queue :next)
          updated-queue (push next-queue element)]
      (assoc queue :next updated-queue))
    ))

;if the value is nil I have reached the send-off
;when you pop size it shrinks by 1
;break the link between the list on the :next

(defn special-pop [queue]
  (if (some? (get queue :content))
    (dissoc queue :content)
      queue))

