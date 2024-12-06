package com.yearup.dealership;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract) {
        String filePath = "src/main/resources/contracts.csv";


        try {
            FileWriter fileWriter = new FileWriter(filePath, true);

            String lineToWrite;


            if (contract instanceof SalesContract) {
                lineToWrite = String.format("SALE|%s|%s|%s|%s|%f|%f|%b\n",
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getVehicleSold(),
                        contract.getTotalPrice(),
                        ((SalesContract) contract).getProcessingFee(),
                        ((SalesContract) contract).isWantToFinance());
            } else if (contract instanceof LeaseContract) {
                lineToWrite = String.format("LEASE|%s|%s|%s|%s|%f|%f\n",
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getVehicleSold(),
                        contract.getTotalPrice(),
                        ((LeaseContract) contract).getLeaseFee());
            } else {

                return;
            }

            fileWriter.write(lineToWrite);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}