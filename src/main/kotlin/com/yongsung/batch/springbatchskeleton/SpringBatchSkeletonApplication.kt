package com.yongsung.batch.springbatchskeleton

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing
@SpringBootApplication
class SpringBatchSkeletonApplication

fun main(args: Array<String>) {
    runApplication<SpringBatchSkeletonApplication>(*args)
}
