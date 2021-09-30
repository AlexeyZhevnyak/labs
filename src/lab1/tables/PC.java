package lab1.tables;

import lab1.AbstractTable;

import java.io.Serializable;
import java.util.Formatter;

public class PC extends AbstractTable{

    public PC(int id, String cpu, String gpu, int ram, String motherboard, int number) {
        setId(id);
        setCpu(cpu);
        setGpu(gpu);
        setRam(ram);
        setMotherboard(motherboard);
        setNumber(number);
    }

    private String cpu;
    private String gpu;
    private int ram;
    private String motherboard;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }


    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s  %20s %20d %20s %20s", getId(), cpu, gpu, ram, motherboard, number).toString();
    }

}
