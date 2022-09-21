package com.yongsung.batch.springbatchskeleton.job

import com.yongsung.batch.springbatchskeleton.common.extension.getLogger
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimpleJobConfiguration(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory
) {
    private val logger = getLogger()


    @Bean
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .start(simpleStep1())
            .build()
    }

    @Bean
    fun simpleStep1(): Step {
        return stepBuilderFactory.get("simpleStep1")
            .tasklet { contribution, chunkContext ->
                logger.info(">>>>> This is Step1")
                RepeatStatus.FINISHED
            }
            .build()
    }
}