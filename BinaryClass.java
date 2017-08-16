//Class of functions for the binary simulator program
//by www.neiljohan.com

public class BinaryClass implements BinaryInterface
{
    int tNumber;
    String tBinary;
    String tBinary1,tBinary2;
    
    
    public BinaryClass(final int tDec)
        {
            tNumber = tDec;
        }

    public BinaryClass(final String tBin)
        {
            tBinary = tBin;
        }

    public BinaryClass(final String tBin1, final String tBin2)
        {
            tBinary1 = tBin1;
            tBinary2 = tBin2;
        }
    
    public int toDecimal()
        {
            int tTotal=0;
            int tBinaryValue=128;
           
            if (tBinary.length()!= 8){
                System.out.println("The binary number must be 8 digits long");
                System.exit(1);
            }
    
            for (int i=0; i<8; i++){
                String tChar = tBinary.substring(i,i+1);
                int iChar = new Integer(tChar).intValue();
                tTotal=tTotal+(iChar*tBinaryValue);
                tBinaryValue=tBinaryValue/2;
            }
            return tTotal;
        }

    public String toBinary()
        {
            int BinaryValue=128;
            String BinaryString="";
            for (int i=0;i<8;i++)
            {
                if (tNumber - BinaryValue >=0)
                {
                    tNumber = tNumber - BinaryValue;
                    BinaryString=BinaryString+1;
                }
                else
                {
                    BinaryString=BinaryString+0;
                }
                BinaryValue=BinaryValue/2;
            }
            return BinaryString;
        }

    public String TwosComplement()
        {
            String BinaryString="";

            for (int i=0; i<8; i++){
                String tChar = tBinary.substring(i,i+1);
                int iChar = new Integer(tChar).intValue();

                if (iChar ==0)
                {
                    BinaryString=BinaryString+1;
                }
                else
                {
                    BinaryString=BinaryString+0;
                }
            }

            BinaryString = BinaryAdd(BinaryString,"00000001");
            return BinaryString;
        }
    
    public String BinaryAdd(String Binary1, String Binary2)
        {
            int Carry=0;
            String[] BinaryBits = new String [8];
            String BinaryString="";

            if (Binary1.length()!=8 || Binary2.length()!=8){
                System.out.println("The binary number must be 8 digits long");
                System.exit(1);
            }

            for (int i=7; i>=0; i--){
                String tChar = Binary1.substring(i,i+1);
                int Bit1 = new Integer(tChar).intValue();

                String tChar2 = Binary2.substring(i,i+1);
                int Bit2 = new Integer(tChar2).intValue();

                int Total = Bit1 + Bit2 + Carry;

                if (Total == 0){
                    BinaryBits[i]="0";
                    Carry=0;
                }
                else if(Total== 1){
                    BinaryBits[i]="1";
                    Carry=0;
                }
                else if(Total == 2){
                    BinaryBits[i]="0";
                    Carry=1;
                }
                else if(Total == 3){
                    BinaryBits[i]="1";
                    Carry=1;
                }
            }

            if (Carry==1){
                System.out.println("Overflow Error!");
            }

            for (int j=0; j<=7; j++){
                BinaryString=BinaryString+BinaryBits[j];
            }
            return BinaryString;
        }
}