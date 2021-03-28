package com.example.mytest

import com.example.mytest.ui.MyFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    MyFragmentTest::class
)
class SuiteTest