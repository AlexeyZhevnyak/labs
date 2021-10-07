package lab1.tables;

import lab1.AbstractTable;
import lab1.ITable;

import java.util.Formatter;

public class PC extends AbstractTable {

    private String cpu;
    private String gpu;
    private int ram;
    private String motherboard;
    private int number;

    public PC(int id, String cpu, String gpu, int ram, String motherboard, int number) {
        setId(id);
        setCpu(cpu);
        setGpu(gpu);
        setRam(ram);
        setMotherboard(motherboard);
        setNumber(number);
    }

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

    @Override
    public int compareTo(ITable o) {
        PC pc = (PC) o;
        int t1 = this.number - pc.number;
        if (t1 == 0) {

            int t2 = this.ram - pc.ram;
            if (t2 == 0)
                return this.cpu.compareTo(pc.cpu);

            return t2;
        }
        return t1;
    }
}
