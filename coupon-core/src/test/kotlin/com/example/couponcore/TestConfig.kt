package com.example.couponcore

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource

@TestPropertySource(properties = ["spring.config.name=application-core"])
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest(classes = [CoreConfigurationLoader::class])
class TestConfig