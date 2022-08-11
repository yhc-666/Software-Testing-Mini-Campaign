from itertools import count
import random
import os
import re
import pandas as pd


class Fuzzing_generator:
    def __init__(self):
        self.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        self.digit = "0123456789"
        self.all_headers = ["Customer ID#", "Account No.", "Currency", "Type", "Balance"]

    def generate_test_csv(self, fuzz_rate, min_row_num, max_row_num, id_not_ordered, file_name):
        # randomly choose cols
        col_num = random.randint(0, 4)
        col_index = random.sample([0, 1, 2, 3], col_num)
        headers = [self.all_headers[i] for i in col_index]

        # decide whether add col balance
        missing_balance = random.random() < 0.05
        if not missing_balance:
            headers.append("Balance")

        df = pd.DataFrame(columns=headers)

        # number of rows in this file
        row_num = random.randint(min_row_num, max_row_num)

        # current id
        count_id = 1

        for _ in range(row_num):
            row = {}
            for header in headers:
                if header == "Customer ID#":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Customer ID#"] = ""
                    else:
                        id = "ID" + str(count_id)
                        row["Customer ID#"] = id
                    count_id += 1


                elif header == "Account No.":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Account No."] = ""
                    else:
                        account = ""
                        # generate 3 cap letters
                        for i in range(3):
                            account += self.letters[random.randint(0, 25)]
                        # plus 8 digits
                        for i in range(8):
                            account += self.digit[random.randint(0, 9)]
                        row["Account No."] = account

                elif header == "Currency":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Currency"] = ""
                    else:
                        cur = ""
                        # generate 3 cap letters
                        for i in range(3):
                            cur += self.letters[random.randint(0, 25)]
                        row["Currency"] = cur

                elif header == "Type":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Type"] = ""
                    else:
                        r = random.random() <= 0.5
                        if r:
                            tp = "SAVINGS"
                        else:
                            tp = "CURRENT"
                        row["Type"] = tp

                elif header == "Balance":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Balance"] = ""
                    else:
                        bal = ""
                        # length of balance
                        r = random.randint(0, 9)
                        for i in range(r):
                            # randomly choose a digit
                            if i == 0:
                                bal += self.digit[random.randint(1, 9)]
                            else:
                                bal += self.digit[random.randint(0, 9)]
                        row["Balance"] = bal

            df = df.append(row, ignore_index=True)

        if id_not_ordered:
            df = df.sample(frac=1)

        df.to_csv(
            f"/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/fuzzing test/test csv files/{file_name}",
            index=False)
