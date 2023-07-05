package Cong_Tru_Nhan_Chia.entity;

public class Caculator {
    public static float caculate(float first , float second , char operator)
    {
        switch (operator)
        {
            case '+':
                return first + second;
            case '-':
                return first-second;
            case '*':
                return first*second;
            case '/':
                if (second!=0)
                {
                    return first/second;
                }else
                {
                    throw new RuntimeException("Khong the chia cho 0");
                }
            default:
                throw new RuntimeException("Khong duoc:");
        }
    }
}
