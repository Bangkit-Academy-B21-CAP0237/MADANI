# Machine Learning

### 01 Data Exploration & Preparation

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

### 05 Inference

This notebook will perform the inference process by taking building damage classification model and road extraction model from the google drive folder. Then plot the building damage mapping and road extraction result.

Requirements:
* Download our model and example images from [this link](https://drive.google.com/drive/folders/1qzkZ4SWOJHRVj-kqrW8jnQxj0XwxVXyr?usp=sharing)
* Upload our model and example images to your own google drive
* Mount this notebook with your google drive account by running the setup code below
* Set the source path to your own google drive path
