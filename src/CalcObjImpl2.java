import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class CalcObjImpl2 extends UnicastRemoteObject implements CalcObject2 {
    public CalcObjImpl2() throws RemoteException{
        super();
    }
    @Override
    public ResultType calculate(InputType inParam) throws RemoteException
    {
        double zm1,zm2;
        ResultType wynik = new ResultType();
        zm1 = inParam.getX1();
        zm2 = inParam.getX2();

        wynik.result_description="Operacja"+ inParam.operation;

        switch (inParam.operation)
        {
            case "add":
                wynik.result=zm1+zm2;
                break;
            case "sub":
                wynik.result=zm1-zm2;
                break;

        }
        return wynik;
    }

}
