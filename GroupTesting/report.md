# Lumingrui

### Bug1

For two adjacent rows(ed:4th  and 5th row) of the totally identical file1 and file2, if we flip the order of these two rows of the one of the file (switch these two rows)and another one doesn’t change and treat them as the two input csv files of the CSVcomparator. The expected output should be an empty csv file but the actual output is the file which contains two 4th row records and the Assert.asserEquals(expect, result) function will throw an error in test case4 “compare two files with flipped row”

### Bug2

When the two input CSV file has different number of rows and has different repetitive rows,  the CSVcomparator will throw ArrayIndexOutOfBoundsException. The bug is found by "Both files have several(>=1) repeat customer IDs" test case.

# Wangshiyu

According to my test cases, there is no bug found in his code.

# Kevin Richan

According to my test cases, there is no bug found in his code.