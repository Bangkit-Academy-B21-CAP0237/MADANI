<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\ReportController;
use App\Http\Controllers\PostController;
use App\Http\Controllers\MapController;
use App\Http\Controllers\DistrictController;
use App\Http\Controllers\DirectionController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group([
    'middleware' => 'api',
    'prefix' => 'auth'
], function ($router) {
    Route::get('me', [AuthController::class, 'me'])->name('auth.me');
    Route::post('login', [AuthController::class, 'login'])->name('auth.login');
    Route::post('register', [AuthController::class, 'register'])->name('auth.register');
    Route::post('logout', [AuthController::class, 'logout'])->name('auth.logout');
    Route::post('refresh', [AuthController::class, 'refresh'])->name('auth.refresh');
});

Route::group([
    'middleware' => 'api',
    'prefix' => 'user'
], function ($router) {
    Route::get('/', [UserController::class, 'index'])->name('user.all');
    Route::get('/{id}', [UserController::class, 'show'])->name('user.byId');
    Route::post('/', [UserController::class, 'store'])->name('user.create');
    Route::put('/{id}', [UserController::class, 'update'])->name('user.update');
    Route::delete('/{id}', [UserController::class, 'destroy'])->name('user.delete');
});

Route::group([
    'middleware' => 'api',
    'prefix' => 'report'
], function ($router) {
    Route::get('/', [ReportController::class, 'index'])->name('report.all');
    Route::get('/{id}', [ReportController::class, 'show'])->name('report.byId');
    Route::post('/', [ReportController::class, 'store'])->name('report.create');
    Route::put('/{id}', [ReportController::class, 'update'])->name('report.update');
    Route::delete('/{id}', [ReportController::class, 'destroy'])->name('report.delete');
});

Route::group([
    'middleware' => 'api',
    'prefix' => 'post'
], function ($router) {
    Route::get('/', [PostController::class, 'index'])->name('post.all');
    Route::get('/{id}', [PostController::class, 'show'])->name('post.byId');
    Route::post('/', [PostController::class, 'store'])->name('post.create');
    Route::put('/{id}', [PostController::class, 'update'])->name('post.update');
    Route::delete('/{id}', [PostController::class, 'destroy'])->name('post.delete');
});

Route::group([
    'middleware' => 'api',
    'prefix' => 'map'
], function ($router) {
    Route::get('/', [MapController::class, 'index'])->name('map.all');
    Route::get('/{id}', [MapController::class, 'show'])->name('map.byId');
    Route::post('/', [MapController::class, 'store'])->name('map.create');
    Route::put('/{id}', [MapController::class, 'update'])->name('map.update');
    Route::delete('/{id}', [MapController::class, 'destroy'])->name('map.delete');
});

Route::group([
    'middleware' => 'api',
    'prefix' => 'district'
], function ($router) {
    Route::get('/', [DistrictController::class, 'index'])->name('district.all');
    Route::get('/{id}', [DistrictController::class, 'show'])->name('district.byId');
    Route::post('/', [DistrictController::class, 'store'])->name('district.create');
    Route::put('/{id}', [DistrictController::class, 'update'])->name('district.update');
    Route::delete('/{id}', [DistrictController::class, 'destroy'])->name('district.delete');
});

Route::group([
    'middleware' => 'api',
    'prefix' => 'direction'
], function ($router) {
    Route::get('/', [DirectionController::class, 'index'])->name('direction.all');
    Route::get('/{id}', [DirectionController::class, 'show'])->name('direction.byId');
    Route::post('/', [DirectionController::class, 'store'])->name('direction.create');
    Route::put('/{id}', [DirectionController::class, 'update'])->name('direction.update');
    Route::delete('/{id}', [DirectionController::class, 'destroy'])->name('direction.delete');
});