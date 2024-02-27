#include "header.h"

extern char persnal_list[200][10][20];
extern char insurance_list[40][11][20];
extern int persnal_list_line;
extern int insurance_list_line;
extern char persnal_list_txt[];
extern char insurance_list_txt[];
extern int age_list[200][2];
extern int calculated_list[200][15];

void age_calc() {
	int dyaer = 0;//�o�ߔN
	int dmonth = 0;//�o�ߌ�
	int dday = 0;//�o�ߓ�
	int year = 0;//�a���N
	int month = 0;//�a����
	int day = 0;//�a����

	for (int i = 0; persnal_list_line > i; i++) {

		//�l���X�g�̒a���N�A��,���𐔒l��
		year = atoi(&persnal_list[i][3]);
		month = atoi(&persnal_list[i][4]);
		day = atoi(&persnal_list[i][5]);

		//�o�ߔN�ƌo�ߌ����Z�o
		dyaer = 2005 - year;

		if (month <= 4) {
			dmonth = 4 - month;
		}
		else {
			dyaer--;
			dmonth = 12 + 4 - month;
		}

		if (day <= 5) {
			dday = 5 - day;
		}
		else {
			dmonth--;
			dday = 30 + 5 - day;
		}

		dmonth += dday / 30;
		dyaer += dmonth / 12;
		

		//�o�ߔN�A�����i�[
		age_list[i][0] = dyaer;
		age_list[i][1] = dmonth;
	}
}

void calc() {
	//�Љ�ی���V���z�̐��l��
	int serach_insurance[40];
	int calc_list_line;
	int grade_line;

	for (int i = 0; insurance_list_line > i; i++) {
		serach_insurance[i] = atoi(&insurance_list[i][3]);//�i�[
	}

	//�v�Z����
	for (int calc_list_line = 0; persnal_list_line > calc_list_line; calc_list_line++) {

		//��{�c�ƒʋΐ��l���A�i�[
		for (int i = 0; 3 > i; i++) {// n:0 ��{�@n:1 �c�Ɓ@n:2 �ʋ�
			calculated_list[calc_list_line][i] = atoi(&persnal_list[calc_list_line][i + 6]);//calculated_list[�s][��]
		}

		//�x�����v�i�[
		calculated_list[calc_list_line][3] = calculated_list[calc_list_line][0] + calculated_list[calc_list_line][1] + calculated_list[calc_list_line][2];

		//��������
		for (int i = 0; insurance_list_line - 1 > i; i++) {
			if (serach_insurance[i] > calculated_list[calc_list_line][3]) {
				grade_line = i;
				break;
			}
			grade_line = 38;

		}

		//���N�ی��i�[
		if (age_list[calc_list_line][0] < 40) {

		//���ی���Y��
			calculated_list[calc_list_line][4] = (int)(atof(&insurance_list[grade_line][5]) + 0.49);//calculated_list[�s][��] �l���S���N�ی�
			calculated_list[calc_list_line][9] = (int)(atof(&insurance_list[grade_line][5]) + 0.49);//calculated_list[�s][��] ��Е��S���N�ی�
		}
		else {

		//���ی��Y��
			calculated_list[calc_list_line][4] = (int)(atof(&insurance_list[grade_line][7]) + 0.49);//calculated_list[�s][��] �l���S���N�ی�
			calculated_list[calc_list_line][9] = (int)(atof(&insurance_list[grade_line][7]) + 0.49);//calculated_list[�s][��] ��Е��S���N�ی�
		}

		//�����N�����l���A�i�[
		calculated_list[calc_list_line][5]  = (int)(atof(&insurance_list[grade_line][9]) + 0.49);//calculated_list[�s][��] �l���S�����N��
		calculated_list[calc_list_line][10] = (int)(atof(&insurance_list[grade_line][9]) + 0.49);//calculated_list[�s][��] ��Е��S�����N��

		//�ٗp�ی����l���A�i�[
		calculated_list[calc_list_line][6] = calculated_list[calc_list_line][3] * 7 / 1000;//�l���S�ٗp�ی�
		calculated_list[calc_list_line][11] = calculated_list[calc_list_line][3] * 11 / 1000;//��ƕ��S�ٗp�ی�

		//�J�Еی�
		calculated_list[calc_list_line][12] = calculated_list[calc_list_line][3] * 5 / 1000;

		//�����蓖
		calculated_list[calc_list_line][13] = (int)atof(insurance_list[grade_line][10]);//�����蓖�i�[

		//�T���v
		calculated_list[calc_list_line][7] = calculated_list[calc_list_line][4] + calculated_list[calc_list_line][5] + calculated_list[calc_list_line][6];

		//���x��
		calculated_list[calc_list_line][8] = calculated_list[calc_list_line][3] - calculated_list[calc_list_line][7];

		//�J����
		calculated_list[calc_list_line][14] = calculated_list[calc_list_line][3] + calculated_list[calc_list_line][9] + calculated_list[calc_list_line][10] + calculated_list[calc_list_line][11] + calculated_list[calc_list_line][12] + calculated_list[calc_list_line][13];
	}
}
