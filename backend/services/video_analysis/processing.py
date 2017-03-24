import numpy as np
import time
import cv2
import datetime


class Analyzer():
	def __init__(self):
		self.avg_bpm = self.cnt = self.fps = self.bpm = 0
		self.index = 1
		self.incoming_frame = self.outgoing_frame = np.zeros((10, 10))
		self.face = False
		self.find = True
		self.buffer_size = 250
		self.buffer_data = self.times = self.t_times = \
			self.freqs = self.fft = self.breaths = self.face_rect = []
		self.previous__frame = None
		self.cascade = cv2.CascadeClassifier("frontface_cascade.xml")
		self.last_fft_center = np.array([0, 0])
		self.t0 = time.time()

	# shift zero frequency to center
	def fft_shift(self, detected_forehead):
		x, y, w, h = detected_forehead
		center = np.array([x + 0.5 * w, y + 0.5 * h])  # approximation
		shift = np.linalg.norm(center - self.last_fft_center)
		self.last_fft_center = center
		return shift

	# get absolute coordinates of forehead
	# head_rel_x and head_rel_y => relative coordinates
	def get_forehead_coords(self, head_rel_x, head_rel_y, head_w, head_h):
		pass

	def get_mean_intensity(self, boundary_coords):
		pass

	# all the main calculations will be done here
	def analyze(self):
		pass
