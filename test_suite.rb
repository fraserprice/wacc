#!/usr/bin/ruby
# A test suite for checking ANTLR tokens parsing

require "open3"

TESTS = `find ./tests`

passed = 0
total_tests = 0

failed_tests = []

puts "Running ..."

TESTS.each_line do |test|
  test = test.chomp

  if (!File.directory? test) && (test.end_with? ".wacc")
    _, stderr, _ = Open3.capture3("./grun antlr.WACC program -tokens < #{test}")

    print "Test #{total_tests + 1}: "
    if stderr.empty?
      passed += 1
      print "PASSED"
    else
      print "FAILED"
      failed_tests.push test
    end

    puts " #{test}"
    puts stderr unless stderr.empty?

    total_tests += 1
  end
end

puts "Completed: #{passed}/#{total_tests} passed"

puts "Failed: "
failed_tests.each do |failed_test|
  puts failed_test
end