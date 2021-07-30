package main.java.service;

import main.java.model.CryptoItem;

import java.util.List;

public interface IParseFileService {

    List<CryptoItem> parseFile(String filename);
}
