# Machine Learning

## How to replicate our project

> Read these explanation about the notebook below and follow the instruction

### 01 Building Damage Detection - Data Exploration & Preparation

This notebook contains the exploration process on the 2018 Palu tsunami data. The data provided by xview has additional information about the metadata of each satellite image. Additional information about the image is entered into a file with json format. We will dive into the information provided and explore from the data provided. After running this notebook you will get a csv containing train and test data.

To run this notebook you need kaggle api file to interact with datasets to download the data. Upload your kaggle API file to '/content' directory and you will be ready to run this notebook.

If you've never used the kaggle API, please follow this instruction:
* Log in to [Kaggle](https://www.kaggle.com/). Create a new account if you don't have one.
* Go to your account settings by clicking on the top right.
* Scroll down to the API section.
* Click on 'Create New API Token' button to download the token as a JSON file.
* Upload it to '/content' directory in your colab environment.

### 02 Building Damage Detection - Model

This notebook contains the model for our machine learning damage classification task. The image that will be used for training is a polygon image that has been extracted from a complete satellite image. 

What will this notebook do:
- Generate a csv file with polygon ID and it's corresponding damage labels. We use this csv later to input data into the model using `flow_from_dataframe`. 
- Apply multiple augmentations to our training data for all polygon images such as ; horizontal flip, vertical flip, rotation, width and height shift. 
- Resize our input images to 128x128, this number is not too small to cause loss of necessary information, but not too large to cause our CNN performance slowed down.
- Apply undersampling technique to change the composition of the training dataset because the number of buildings that has no damage and the number of destroyed buildings are imbalance.
- Create a Keras Model with the Sequential linear stack of layers. All Convolutional blocks will use ReLU for the activation parameter, We call Flatten method to transform 3 dimensional feature maps into 1 dimensional tensor.
- Training the model
- Plot the accuracy and loss using livelossplot
- Save the model

### 03 Road Extraction - Data Exploration & Preparation

This dataset is provided by Road Extraction Dataset from [DeepGlobe Challenge](https://www.kaggle.com/balraj98/deepglobe-road-extraction-dataset). DeepGlobe Challenge provided us with images that paired with labels. The image itself is a satellite imagery shot of regions that contain road in it. And the label mask is a grayscale image, with white standing for road pixel, and black standing for background.

To run this notebook you need kaggle api file to interact with datasets to download the data. Upload your kaggle API file to '/content' directory and you will be ready to run this notebook.

If you've never used the kaggle API, please follow this instruction:
* Log in to [Kaggle](https://www.kaggle.com/). Create a new account if you don't have one.
* Go to your account settings by clicking on the top right.
* Scroll down to the API section.
* Click on 'Create New API Token' button to download the token as a JSON file.
* Upload it to '/content' directory in your colab environment.

### 04 Road Extraction - Model

This notebook contains the model for our machine learning road extraction model. After you are finished with the step number [03](https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/a6d34718ee2c200338bedc71aa128446513d9c65/Machine%20Learning/03%20Road%20Extraction%20-%20Data%20Preparation%20&%20Exploration.ipynb), you can directly load the images and masks array into the model as x labels and y labels.

What will this notebook do:
- Resize our input images to 256x256
- We are using UNet architecture so there will be encoding and decoding path.
- We are creating keras model with residual block on the encoding and decoding path. We also need to concatenate each convolutional block and input it on the decoding path.
- Training the model
- Plot the accuracy and loss
- Save the model

### 05 Inference

This notebook will perform the inference process by taking building damage classification model and road extraction model from the google drive folder. Then plot the building damage mapping and road extraction result.

Requirements:
* Download our model and example images from [this link](https://drive.google.com/drive/folders/1qzkZ4SWOJHRVj-kqrW8jnQxj0XwxVXyr?usp=sharing)
* Upload our model and example images to your own google drive
* Mount this notebook with your google drive account by running the setup code below
* Set the source path to your own google drive path
