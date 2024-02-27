#pragma once
#include <stdio.h>
#include <stdlib.h>

#define SUCCESS 0
#define FAILURED -1

int persnal_list_input();
int insurance_list_input();
void age_calc();
void calc();
int output(char *, int *);
void make_default_list();
void make_only_list();
void make_up_list();
void make_down_list();