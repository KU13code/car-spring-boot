package ru.car.buycar.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.car.buycar.facades.ImageFacade;
import ru.car.buycar.models.Car;
import ru.car.buycar.models.Image;
import ru.car.buycar.repositories.CarRepository;
import ru.car.buycar.repositories.ImageRepository;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
    private final CarRepository carRepository;
    private final ImageRepository imageRepository;
    private final ImageFacade imageFacade;

    public List<Car> getAll(){
        log.info("Get all Car");
        return carRepository.findAll();
    }


    public Image getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElse(null);
        image.setBytes(decompressBytes(image.getBytes()));
        return image;
    }


    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void save(Car car, MultipartFile image) throws IOException {
        Image imageModel = imageFacade.toEntity(image);
        imageModel.setBytes(compressBytes(image.getBytes()));
        car.setImage(imageModel);
        log.info("Saving new {}", car.getBrand());
        carRepository.save(car);

    }

    public List<Car> search(String key) {
        return searchBySerchWord(key, carRepository.findAll());
    }

    private List<Car> searchBySerchWord(String searchWord, List<Car> cars){
        List<Car> searchCars = new ArrayList<>();

        String lowerSearchWord = makeStringToLowerCase(searchWord);
        char[] searchWordToCharArray = lowerSearchWord.toCharArray();

        for (int a = 0; a < cars.size(); a++){
            String lowerCarsBtand = makeStringToLowerCase(cars.get(a).getBrand());
            char[] chars = lowerCarsBtand.toCharArray();
            for (int i = 0; i < chars.length; i++){
                for (int j = 0; j < searchWordToCharArray.length; j++) {
                    try {
                        if (chars[i] == searchWordToCharArray[j]){
                            if (chars[i + 1] == searchWordToCharArray[j + 1]) {
                                if (chars[i + 2] == searchWordToCharArray[j + 2]) {
                                    //if (chars[i + 3] == searchWordToCharArray[j + 3]) {   поиск от 3х сиволов.
                                        if (!searchCars.contains(cars.get(a))){
                                            searchCars.add(cars.get(a));
                                            break;
                                        }
                                    //}
                                }
                            }
                        }
                    }catch (IndexOutOfBoundsException e){
                        break;
                    }
                }

            }
        }return searchCars;

    }

    private String makeStringToLowerCase(String word){
        String lowerString = "";
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            lowerString += Character.toLowerCase(c);
        }
        return lowerString;
    }

    private static byte[] decompressBytes(byte[] data){
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()){
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        }catch (IOException | DataFormatException e){
            log.error("Cannot decompress Bytes");
        }
        return outputStream.toByteArray();
    }

    private byte[] compressBytes(byte[] data){
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()){
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        }catch (IOException e){
            log.error("Cannot compress Bytes");
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
}
