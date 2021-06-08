# MADANI
> Mapping and Data Assesment for Natural Incident

Madani is an application that makes it easier for volunteers to carry out disaster mitigation by classifying routes and impact buildings based on post-disaster satellite images.


## Machine Learning

### Overview

Disaster mitigation follow the processes included in the standard operational procedures according to their level of disaster. MADANI is intended to support one of these processes, mainly in estimating areas and buildings affected by disasters, as well as in determining post-disaster logistics distribution channels. To solve this problem, we propose two steps machine learning processes that can take images from satellites, detect existing roads, then identify damage of buildings.

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/master/Machine%20Learning/Media/Overview.jpg" alt="Overview"/>

### Building Damage Classification

#### Dataset
We use xBD dataset, a dataset for assessing building damage from satellite imagery. xBD provides pre and post-event satellite imagery from a variety of disaster events with building polygons, classification labels for damage types, labels of damage level, and correspoinding satellite medatada. Detailed information can be found at [xView2](https://xview2.org/) site. We use the Palu 2018 tsunami disaster satellite data provided by xBD which can be downloaded from [here](https://www.kaggle.com/auliawicaksono/palu-disaster-satellite-images). This dataset contain 226 pre and post disaster satellite imagery, with 16,764 building polygons.

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/af2a97051daa43d2821308da5d4b1fd6cd757e01/Machine%20Learning/Media/Building%20Damage%20Classification%20Dataset.jpg" alt="Building Damage Detection Dataset" width="500"/>

#### Data Preparation

###### Crop Building Image

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/master/Machine%20Learning/Media/Building%20Damage%20Detection%20Preprocessing.jpg" alt = "Crop Building Image" width="500"/>

The image that will be used for training is a polygon image that has been extracted from a complete satellite image. After do some extraction process, then we generate a csv file with polygon ID and it's corresponding damage labels. We will use this csv later to input data into the model using [flow_from_dataframe](https://www.tensorflow.org/api_docs/python/tf/keras/preprocessing/image/ImageDataGenerator#flow_from_dataframe).  We will apply multiple augmentations to our training data for all polygon images such as ; horizontal flip, vertical flip, rotation, width and height shift. We resize our input images to 128x128, this number is not too small to cause loss of necessary information, but not too large to cause our CNN performance slowed down.

###### Undersampling

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/master/Machine%20Learning/Media/Building%20Damage%20Classification%20Undersampling.jpg" alt = "Undersampling" width="500"/>

There is an imbalance number of classes in the 2018 Palu tsunami dataset. We have explored the model and train the model with [class weights](https://www.tensorflow.org/tutorials/structured_data/imbalanced_data#train_a_model_with_class_weights), but because the imbalance is very extreme (there is only 1 building polygon that is labeled in class 3 out of a total of 16,764 building polygons), so we decide to reduce the classification target from 4 classes to binary classification. We apply undersampling technique to change the composition of the training dataset because the number of buildings that has no damage and the number of destroyed buildings are imbalance.

##### Model

We create a Keras Model with the [Sequential](https://www.tensorflow.org/api_docs/python/tf/keras/Sequential) linear stack of layers. All Convolutional blocks will use ReLU for the activation parameter, We call [Flatten](https://www.tensorflow.org/api_docs/python/tf/keras/layers/Flatten) method to transform 3 dimensional feature maps into 1 dimensional tensor.

<details>
<summary>CNN Architecture</summary>
<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/master/Machine%20Learning/Media/Building%20Damage%20Classification%20Plot%20Model.png" alt = "Model Plot 00"/>
</details>


<details>
<summary>Model Accuracy</summary>
<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/master/Machine%20Learning/Media/Building%20Damage%20Classification%20Model%20Accuracy.JPG" alt = "Model Accuracy width="500"/>
</details>

### Road Extraction

#### Dataset
This dataset is provided by Road Extraction Dataset from [DeepGlobe Challenge](https://www.kaggle.com/balraj98/deepglobe-road-extraction-dataset). DeepGlobe Challenge provided us with images that paired with labels. The image itself is a satellite imagery shot of regions that contain road in it. And the label mask is a grayscale image, with white standing for road pixel, and black standing for background.

The images that we used to train our model is satellite imagery shot of regions that contain road in it. And the label mask is a grayscale image, with white standing for road pixel, and black standing for background. This images we used only from the training folder from you can see in the [DeepGlobe Challenge](https://www.kaggle.com/balraj98/deepglobe-road-extraction-dataset) dataset and from approximately 6000 images and labels later split it into validation dataset in training model.

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/1b937bd4de1301c8e3f77fb4042592c82089b343/Machine%20Learning/Media/Road%20Extraction%20Training%20Imagessss.png" alt="Road Extraction Training Images" width="500"/>

#### Data Preparation

We create our own data generator for the road extraction model. First, we created two empty numpy arrays for each images and labels using [numpy.zeros](https://www.geeksforgeeks.org/numpy-zeros-python/), then we convert the satellite images and labels into arrays using [OpenCV](https://docs.opencv.org/master/) and append them into the created numpy arrays. This will make each empty numpy arrays filled with images and labels arrays.

##### Image Arrays

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/35318c9dde11941b138e53814c745834fcb69ff0/Machine%20Learning/Media/Road%20Extraction%20Images%20Arrays.png" alt="Road Extraction Image Arrays" width="500"/>

##### Labels Arrays

<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/9cb1e1e3bbc4141e7c1c6068a55a11944836e6d4/Machine%20Learning/Media/Road%20Extraction%20Labels%20Arrays.png" alt="ResUnet Architecture" width="500"/>

We will not use anymore modification (yet) such as augmentation because we need to process the images and the labels as it is to mantain the preciseness.

##### Model

<details>
<summary>ResUnet Architecture</summary>
<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/d9272f21ae78baf4b2dfb1ddca65f7d84eab7a14/Machine%20Learning/Media/ResUnet%20Architecture.png" alt = "ResUnet Architecture"/>
</details>

<details>
<summary>Model Accuracy</summary>
<img src="https://github.com/Bangkit-Academy-B21-CAP0237/MADANI/blob/master/Machine%20Learning/Media/Road%20Extraction%20Model%20Accuracy.JPG" alt = "Model Accuracy width="500"/>
</details>
