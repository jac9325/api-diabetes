package com.servicediabetes.ApiDiabetesDomain.ArticleImage;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ArticleImageService {
    public Resource load(String filename) throws MalformedURLException;
	public String copy(MultipartFile file) throws IOException;
	public boolean delete(String filename);
	public String getUrlImage(String filename);
}
