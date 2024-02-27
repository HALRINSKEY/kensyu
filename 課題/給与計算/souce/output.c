#include "header.h"

extern char persnal_list[200][10][20];
extern int calculated_list[200][15];
extern int age_list[200][2];
extern char default_file[];
extern int persnal_list_line;
extern int default_list[200];
extern int only_man_list[200];
extern int only_woman_list[200];
extern int cost_up_list[200];
extern int cost_down_list[200];

int output(char *filename, int *list_array) {//(�o�͂���t�@�C�����A�@�o�͂���t�@�C���̍s)
	int calculated_list_sum[15] = {0};

	//�t�@�C���I�[�v��
	FILE* fp;
	errno_t err;

	err = fopen_s(&fp, filename, "w");
	if (err != 0) {
		return FAILURED;
	}

	//1���R�[�h�ڏ�������
	fputs("�l���,,,,�l���^,,,,,,,,,��ИJ����\n", fp);

	//2���R�[�h�ڏ�������
	fputs("�m�n,����,����,�N��^��,��{,�c��,�ʋ�,�x�����v,���N�ی�,�����N��,�ٗp�ی�,�T��,���x��,���N�ی�,�����N��,�ٗp�ی�,�J�Еی�,�玙�蓖,�J����\n", fp);
	
	
	for (; *list_array >= 0; list_array++) {
		//NO��������
		fprintf(fp, "%04d,", atoi(&persnal_list[*list_array][0]));

		//���O��������
		fprintf(fp, "%s,", persnal_list[*list_array][1]);

		//����

		if (persnal_list[*list_array][2][0] == '1') {
			fprintf(fp, "�j,");
		}
		else {
			fprintf(fp, "��,");
		}

		//�N��o�ߌ�
		fprintf(fp, "%02d/%02d", age_list[*list_array][0], age_list[*list_array][1]);

		//�v�Z�������ʏ�������
		for (int i = 0; 15 > i; i++) {
			fprintf(fp, ",%d", calculated_list[*list_array][i]);

			calculated_list_sum[i] += calculated_list[*list_array][i];
		}

		fprintf(fp, "\n");
	}

	//�������R�[�h
	fprintf(fp, "���v,,,");

	//���v����������
	for (int i = 0; 15 > i; i++) {
		fprintf(fp, ",%d", calculated_list_sum[i]);
	}
	fprintf(fp, "\n");
	

	//�t�@�C�������
	fclose(fp);
	return SUCCESS;
}

void make_default_list() {
	//���Ԃ̃��X�g�쐬
	int i;
	for (i = 0; persnal_list_line > i; i++) {
		default_list[i] = i;
	}

	default_list[i] = -1;
}

void make_only_list() {
	int man_index = 0;
	int woman_index = 0;


	for (int i = 0; persnal_list_line > i; i++) {
		if (persnal_list[i][2][0] == '1') {
			//�j���X�g
			only_man_list[man_index] = i;
			man_index++;
		}
		else {
			//�����X�g
			only_woman_list[woman_index] = i;
			woman_index++;
		}
	}

	only_man_list[man_index] = -1;
	only_woman_list[woman_index] = -1;

}

void make_up_list() {
	int temp_list[122][2];
	int temp = 0;
	int sorttimes = persnal_list_line - 1;
	int cost_index;

	for (int i = 0; persnal_list_line > i; i++) {
		temp_list[i][0] = i;
		temp_list[i][1] = calculated_list[i][14];
	}

	//�����\�[�g
	for (int i = 0; sorttimes > i; i++) {
		for (int j = sorttimes; j > i; j--) {
			if (temp_list[j - 1][1] > temp_list[j][1]) {
				temp = temp_list[j][1];
				temp_list[j][1] = temp_list[j - 1][1];
				temp_list[j - 1][1] = temp;

				temp = temp_list[j][0];
				temp_list[j][0] = temp_list[j - 1][0];
				temp_list[j - 1][0] = temp;
			}
		}
	}

	for (cost_index = 0; persnal_list_line > cost_index; cost_index++) {
		cost_up_list[cost_index] = temp_list[cost_index][0];
	}

	cost_up_list[cost_index] = -1;

}

void make_down_list() {
	int temp_list[122][2];
	int temp = 0;
	int sorttimes = persnal_list_line - 1;
	int cost_index;

	for (int i = 0; persnal_list_line > i; i++) {
		temp_list[i][0] = i;
		temp_list[i][1] = calculated_list[i][14];
	}

	//�~���\�[�g
	for (int i = 0; sorttimes > i; i++) {
		for (int j = sorttimes; j > i; j--) {
			if (temp_list[j - 1][1] < temp_list[j][1]) {
				temp = temp_list[j][1];
				temp_list[j][1] = temp_list[j - 1][1];
				temp_list[j - 1][1] = temp;

				temp = temp_list[j][0];
				temp_list[j][0] = temp_list[j - 1][0];
				temp_list[j - 1][0] = temp;
			}
		}
	}

	for (cost_index = 0; persnal_list_line > cost_index; cost_index++) {
		cost_down_list[cost_index] = temp_list[cost_index][0];
	}

	cost_down_list[cost_index] = -1;

}