package day_1_kotlin.langrus.assignments

// Workshop #5 - inheritance, abstract, interface

// Не исправляй! Дано:
// Объявляем контракт, представляющий некое свойство транспорта.
interface Driveable {
    fun drive()
}

// Объявляем класс пассажирского транспорта вцелом.
// Придадим такому транспорту свойство перемещаться под управлением водителя.
abstract class Transport(protected var passengersCount: Int) : Driveable

// Создадим реальный транспорт: "Велосипед". Он может управляться водителем и перевозит одного пассажира.
class Bicycle : Transport(1) {
    override fun drive() {
        println("Ride a bicycle.")
    }
}


/* Рабочая зона */

// TODO 1: Создай свой интерфейс - контракт, который бы также подошел по смыслу классу транспорт.
//  См. ниже.
// ? Имена классов и файлов Котлин принято называть с заглавной буквы, в формате "camelCase".
// Например: "SomeLongClassName"
interface Sound {
    fun makeSound()
}

// TODO 2: Создай свои собственные классы, например "Bus" и "Car".
//  Эти классы не будут полностью написаны с нуля, они должны расширять общий класс "Transport",
//  и дополнительно реализовывать придуманный тобой интерфейс.
// ? Класс может наследовать только один класс, но реализовывать несколько интерфейсов, например:
// class Kitty(): Cat, Cuteable, Sleepable, Furryable {}
class Bus(var count: Int) : Transport(count), Sound {
    override fun drive() {
        println("Drive Bus")
    }

    override fun makeSound() {
        println("BEEP")
    }

}

class Car(var count: Int) : Transport(count), Sound {
    override fun drive() {
        println("Ride a car.")
    }

    override fun makeSound() {
        println("beep")
    }

}

// TODO 3: Протестируй работоспособность твоего транспорта.
object VehiclesTest {

    // Запусти исполнение main() функции, для выполнения кода.
    @JvmStatic
    fun main(args: Array<String>) {
        testBus()
        testCar()
        testBicycle()
        testBusParts()
    }

    private fun testBus() {
        println("Testing how bus drives...")
        val bus = Bus(25)
        bus.drive()
        bus.makeSound()
    }

    private fun testCar() {
        println("Testing how car drives...")
        val car = Car(5)
        car.drive()
        car.makeSound()
    }

    private fun testBicycle() {
        println("Testing how bicycle drives...")
        val bicycle = Bicycle()
        bicycle.drive()
    }


    /* Бонусные задания */

    // TODO 4: Протестируй агрегаты автобуса, как независимые компоненты.
    //  Т.е. каждый набор независимых свойств - отдельно, чтобы в тестируемой сущности были скрыты все свойства,
    //  не принадлежащие к данному набору.
    private fun testBusParts() {
        val bus = Bus(20)
        println("Testing bus's feature 1...")
        val horn: Sound = bus
        horn.makeSound()

        println("Testing bus's feature 2...")
        val engine: Driveable = bus
        engine.drive()
    }
}