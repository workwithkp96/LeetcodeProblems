package Leetcode;

public class Problem3270_FindTheKeyOfTheNumbers {
    public int generateKey(int num1, int num2, int num3) {
        return Math.min(num1/1000, Math.min(num2/1000, num3/1000)) * 1000 + Math.min(num1/100 % 10, Math.min(num2/100 % 10, num3/100 % 10)) * 100 + Math.min(num1/10 % 10, Math.min(num2/10 % 10, num3/10 % 10)) * 10 + Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
    }
}
