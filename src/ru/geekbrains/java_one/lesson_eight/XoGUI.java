package ru.geekbrains.java_one.lesson_eight;

import javax.swing.*;
import java.awt.*;
//JavaFX
//thymeleaf
//VAADIN
//...

public class XoGUI {
    public static void main(String[] args) {
        new GameWindow();
    }
}

/*
* Почему в классе SettingsWindow в методе, который устанавливает режим игры, нет никакого своего условного чэйнджЛистнера? Несмотря на то, что там уже выбрано умолчание, мы же его можем изменить, а значит будет какое-то событие с мышкой.

как перебороть страх пробовать себя, сменить напраавление (в будущем, конечно)? Для меня это очень большая проблема

Для чего необходимо прописывать ключевое слово static при объявлении метода main, а также использовать это ключевое слово при объявлении методов внутри основного класса, содержащего метод main?

Не поинмаю принципа, как происходит компановка во фрейме компонентов JPanel. По какому принципу они распределяются в пространстве фрейма.

Класс Scanner. Часто встречал информацию, что класс уже неактуален и лучше не привыкать к сканеру, а использовать альтернативные классы (например, BufferedReader + InputStreamReader для ввода с консоли). Так ли это?
Вопрос, который я уже задавал на лекции - "Является ли перегрузка методов частью полиморфизма?". Задал я его, потому что встречал такое мнение, как например в этой статье https://itsobes.ru/JavaSobes/chem-otlichaetsia-peregruzka-ot-pereopredeleniia/ . Якобы при перегрузке используется один и тот же интерфейс, а значит это хоть и "ненастоящий", но полиморфизм. Интересно, что отвечать в таком случае на собеседованиях или лучше не заморачиваться и запомнить, что полиморфизм это только переобределение методов?

Не совсем понял про то,что GameWindow знает про map,а map нет дублирование startNewGame

Поясните, пожалуйста, ещё раз про статические переменные.
По последнему занятию не очень понятно, как узнать весь перечень необходимых методов для каждого объекта. Например, что Button надо создать, связать в группу, добавить. Панель - сделать видимой, задать размер, позицию

Вопрос больше относится к построению алгоритмов, а именно с чего начинать думать и в каком направлении? Когда формулировка задания прописана детально, то вроде есть понимание как можно решить, но если не детально начинаю терятся, т.к. не понимаю что в итоге должно получится.

a. Расскажите про метод File из прошлого ДЗ, как он осущетвляет поиск по папкам.
b. Расскажите чуть подробнее про модификатор доступа static.
c. Какие бывают случаи использования абстрактных методов? Или в большестве случаев можно обойтись пустым конструктором?
d. Еще затык у меня, как понять где хранится объект, а где ссылка на объект?
e. Почему константа магическая?)
f. Как искать пододящие методы (понимаю, что есть гугл (как и ответы на все вопросы), описание методов в идее или подсказки идеи и книги). Но есть понимание, что при написании кода знание методов и принципов их работы, очень упрощает жизнь. Может у васмагический лайхак)

подскажите, как наработать навык правильного составления программ? Как научиться понимать что вот тут у нас используются интерфейсы, тут абстрактные классы, тут оптимальная коллекция ?

1.Столкнулся с проблемой когда переписывал окно самочтоятельно. Захотел создать панель кнопок слева - получилось, но кнопки идут в одну строку. Хотел сдеалть их одна под другой...понял как, но почему-то, когда задаю координаты расположения, ни чего не происходит, одна кнопка накладывается на другую.
2. Ещё бы пару заданий по данной теме, чтобы как можно больше отложилось в голове. Желательно не очень сложные.

Когда использовать this. при обращении к полям, а когда к методам?
Можно еще раз проговорить или нарисовать, как создаться переменная и в нее записывается ссылка при создании объекта.
У меня есть проблема в комплексном видении , что за чем должно быть. (Не в коде, в голове) , чаще всего я смотрю на примерах, какой части еще не хватает. Например, когда мы создаем метод, когда мы прописываем параметры, потом есть тело метода, есть аргументы, есть вывод. Можно на любом коде еще раз проговорить эту последовательность и взаимосвязь.
Можно еще раз повторить про методы гетеры и сеттеры
Перегрузка методов в констркуторе

Хотелось бы ещё раз повторить про наследование и полиморфизм, желательно с новым примером.
Бывают сложности при обращении к объектам и методам, которые находятся в других классах, прошу повторить синтаксис.
Модификаторы final и static. В каких случаях их использование обязательно?
* */
