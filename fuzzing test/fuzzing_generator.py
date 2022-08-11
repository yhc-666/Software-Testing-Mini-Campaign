from itertools import count
import random
import os
import re
import pandas as pd


class Fuzzing_generator:
    def __init__(self):
        self.optional_columns = ["Account No.", "Currency", "Type", "Balance"]
        self.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        self.digit = "0123456789"

    def generate_test_csv(self, fuzz_rate, min_row_num, max_row_num, file_name):
        # cloumns in this csv file
        col_num = random.randint(0, 4)
        col_index = random.sample([0, 1, 2, 3], col_num)
        selected_headers = ["Customer ID"] + [self.optional_columns[i] for i in col_index]

        df = pd.DataFrame(columns=selected_headers)

        # number of rows in this csv file
        row_num = random.randint(min_row_num, max_row_num)

        # current id
        count_id = 1

        for _ in range(row_num):
            row = {}
            for col in selected_headers:
                if col == "Customer ID#":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Customer ID#"] = ""
                    else:
                        id = "ID" + str(count_id)
                        row["Customer ID#"] = id
                    count_id += 1


                elif col == "Account No.":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Account No."] = ""
                    else:
                        account = ""
                        for _ in range(3):
                            account += self.letters[random.randint(0, 25)]
                        for _ in range(8):
                            account += self.digit[random.randint(0, 9)]
                        row["Account No."] = account

                elif col == "Currency":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Currency"] = ""
                    else:
                        cur = ""
                        for _ in range(3):
                            cur += self.letters[random.randint(0, 25)]
                        row["Currency"] = cur

                elif col == "Type":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Type"] = ""
                    else:
                        x = random.random() <= 0.5
                        if x:
                            row["Type"] = "SAVINGS"
                        else:
                            row["Type"] = "CURRENT"


                elif col == "Balance":
                    empty = random.random() < fuzz_rate
                    if empty:
                        row["Balance"] = ""
                    else:
                        balance = ""
                        x = random.randint(0, 9)
                        for i in range(x):
                            if i == 0:
                                balance += self.digit[random.randint(1, 9)]
                            else:
                                balance += self.digit[random.randint(0, 9)]
                        row["Balance"] = balance

            df = df.append(row, ignore_index=True)

        # save as csv
        df.to_csv(
            f"/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/fuzzing test/test csv files/{file_name}",
            index=False)
