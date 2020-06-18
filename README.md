<h1>Аналог ThreadLocal</h1>
<p>Реализация ThreadLocal в двух вариантах</p>
<ul>
  <li>Shared Memory</li>
  <li>Local Storage</li>
</ul>
<h3>Shared Memory (первый способ)</h3>
<p>Принцип заключается в создании общего <a href="https://github.com/Alexeyyy/ThreadLocal/blob/master/src/variant_1/SharedMemory.java">хранилища</a>, а класс <a href="https://github.com/Alexeyyy/ThreadLocal/blob/master/src/variant_1/MyThreadLocal.java">MyThreadLocal</a> является интерфейсом доступа к нему.</p>
<h3>Local Storage (второй способ)</h3>
<p>В данной реализации наследуется <a href="https://github.com/Alexeyyy/ThreadLocal/blob/master/src/variant_2/MyThread.java">новый класс</a> от Thread, для каждого экземпляра которого инициализируется собственное хранилище в виде Hash-таблицы</p>
<p><a href="https://github.com/Alexeyyy/ThreadLocal/blob/master/src/variant_2/MyThreadLocal2.java">Реализация</a> MyThreadLocal2 на самом деле не обязательна в данном случае, так как возможно обратиться к хранилищу через приведение типа.</p>
<p>С другой стороны через класс MyThreadLocal2 удобнее взаимодействовать с данными.</p>
