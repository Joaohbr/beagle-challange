package br.com.zup.gps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GPSApplication

fun main(args: Array<String>) {
    runApplication<GPSApplication>(*args)
}