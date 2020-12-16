package machine

import java.util.Scanner

var waterMachineCapacity = 400
var milkMachineCapacity = 540
var coffeeBeansMachineCapacity = 120
var cupsForService = 9
var money = 550


fun status() {
	println("The coffee machine has:")
	println("$waterMachineCapacity of water")
	println("$milkMachineCapacity of milk")
	println("$coffeeBeansMachineCapacity of coffee beans")
	println("$cupsForService of disposable cups")
	println("$money of money")
}


fun main() {
    do{
        println("Write action (buy, fill, take, remaining, exit): >")
        val action = Scanner(System.`in`)
        var operation = action.next()

        when (operation) {
            "take" -> {
                println("I gave you $money")
                money -= money
            }
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: >")
                val entrance = Scanner(System.`in`)
                val beverage = entrance.next()

                if(beverage == "1"){
                    waterMachineCapacity -= 250
                    coffeeBeansMachineCapacity -= 16
                    cupsForService -= 1
                    money += 4
                } else if (beverage == "2") {

                    if(waterMachineCapacity < 350 ){
                        println("Sorry, not enough water!")
                    } else if (coffeeBeansMachineCapacity < 20){
                        println("Sorry, not enough coffee beans!")
                    } else if (milkMachineCapacity < 75){
                        println("Sorry, not enough milk!")
                    } else {
						waterMachineCapacity -= 350
                    	milkMachineCapacity -= 75
                    	coffeeBeansMachineCapacity -= 20
                    	cupsForService -= 1
                    	money += 7
					}
                } else if (beverage == "3") {
                    waterMachineCapacity -= 200
                    milkMachineCapacity -= 100
                    coffeeBeansMachineCapacity -= 12
                    cupsForService -= 1
                    money += 6
                } /*else if(beverage == "back" ){
					
                    //println("Write action (buy, fill, take, remaining, exit): >")
                    //operation = action.next()
                }*/

            }
            "fill" -> {
                val refill = Scanner(System.`in`)

                println("Write how many ml of water do you want to add: >")
                waterMachineCapacity += refill.nextInt()
                println("Write how many ml of milk do you want to add: >")
                milkMachineCapacity += refill.nextInt()
                println("Write how many grams of coffee beans do you want to add: >")
                coffeeBeansMachineCapacity += refill.nextInt()
                println("Write how many disposable cups of coffee do you want to add: >")
                cupsForService += refill.nextInt()
            }
            "remaining" -> {
                status()
            }
        }
    } while(operation != "exit")
}