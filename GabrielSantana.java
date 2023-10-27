package Exercicios_Extras;

import java.util.Scanner;

public class GabrielSantana {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite seu CPF: ");
            String cpf_str = scn.next();

            // Verificar se o CPF tem 11 dígitos
            if (cpf_str.length() != 11) {
                System.out.println("CPF deve ter 11 dígitos. Tente novamente.");
                continue; // Volte para o início do loop
            }

            char[] cpf_char = cpf_str.toCharArray();
            int[] cpf_int = new int[cpf_char.length];

            for (int i = 0; i < cpf_char.length; i++) {
                cpf_int[i] = Character.getNumericValue(cpf_char[i]);
            }

            // Calcular o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += cpf_int[i] * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito > 9) {
                primeiroDigito = 0;
            }

            // Calcular o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += cpf_int[i] * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito > 9) {
                segundoDigito = 0;
            }

            // Verificar se os dígitos verificadores estão corretos
            if (cpf_int[9] == primeiroDigito && cpf_int[10] == segundoDigito) {
                System.out.println("CPF válido.");
            } else {
                System.out.println("CPF inválido. Tente novamente.");
            }

            System.out.println("Deseja continuar? (S/N): ");
            String resposta = scn.next().toUpperCase();
            if (!resposta.equals("S")) {
                continuar = false;
            }
        }
        scn.close();
    }
}
